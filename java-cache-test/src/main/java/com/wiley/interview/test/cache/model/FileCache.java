package com.wiley.interview.test.cache.model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Comparator;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.wiley.interview.test.cache.impl.JavaCache;
import com.wiley.interview.test.cache.util.Constants;

public class FileCache implements JavaCache {

	Logger log = LogManager.getLogger(FileCache.class);

	private static final ConcurrentHashMap<String, Node> cacheMap = new ConcurrentHashMap<>();
	private int MAX_SIZE;
	private String STRATEGY;

	public FileCache(int maxSize, String strategy) {
		this.MAX_SIZE = maxSize;
		this.STRATEGY = strategy;
	}

	@Override
	public void put(String key, Object value) {
		if (key != null && value != null) {
			while (cacheMap.size() >= MAX_SIZE) {
				evict();
			}
			/*
			 * save file using saveFile(key, value)
			 */
			String filePath = saveFile(key, value);
			Node node = cacheMap.put(key, new Node(filePath));
			if (node != null) {
				/*
				 * Delete the file if the key has previously saved node value.
				 */
				deleteFile(node.getValue().toString());
			}
		}
	}

	@Override
	public Object get(String key) {
		if (cacheMap.containsKey(key)) {
			Node node = cacheMap.get(key);
			/*
			 * retrieve file. File path is retrieve from node value.
			 */
			Object object = retrieveFile(node.getValue().toString());
			if (STRATEGY.equals(Constants.LRU)) {
				node.updateAccessedTime();
			} else {
				node.updateFrequency();
			}
			return object;
		} else {
			return null;
		}
	}

	private void evict() {
		if (STRATEGY.equals(Constants.LRU)) {
			String key = cacheMap.entrySet().stream()
					.min(Comparator.comparing(stringNodeEntry -> stringNodeEntry.getValue().getUpdatedTime())).get()
					.getKey();
			Node node = cacheMap.remove(key);
			/*
			 * remove file. File path is retrieve from node value.
			 */
			deleteFile(node.getValue().toString());
			cacheMap.values().forEach(n -> log.info(n));
		} else {
			String key = cacheMap.entrySet().stream()
					.min(Comparator.comparing(stringNodeEntry -> stringNodeEntry.getValue().getFrequency())).get()
					.getKey();
			Node node = cacheMap.remove(key);
			/*
			 * remove file. File path is retrieve from node value.
			 */
			deleteFile(node.getValue().toString());
			cacheMap.values().forEach(n -> log.info(n));
		}
	}

	@Override
	public String viewCache() {
		return cacheMap.toString();
	}

	private String saveFile(String key, Object val) {
		String fileName = key + ".cache";
		String filePath = getFileLocation() + "/" + fileName;
		try (FileOutputStream fileOut = new FileOutputStream(filePath);
				ObjectOutputStream objectOut = new ObjectOutputStream(fileOut)) {
				objectOut.writeObject(val);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return filePath;
	}

	private Object retrieveFile(String filePath) {
		try (FileInputStream fileOut = new FileInputStream(filePath);
				ObjectInputStream objectOut = new ObjectInputStream(fileOut)) {
				return objectOut.readObject();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

	private void deleteFile(String filePath) {
		File fileIn = new File(filePath);
		fileIn.delete();
	}

	private String getFileLocation() {
		File locationDir = new File("FileCacheS3");
		locationDir.mkdir();
		return locationDir.getAbsolutePath();
	}

	@Override
	public void clearCache() {
		// TODO Auto-generated method stub
		
	}

}
