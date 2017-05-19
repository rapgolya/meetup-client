package hu.bme.aut.mobsoft.mobsoftlab.mock.interceptors;

import android.net.Uri;

import hu.bme.aut.mobsoft.mobsoftlab.network.NetworkConfig;
import hu.bme.aut.mobsoft.mobsoftlab.repository.MemoryRepository;
import hu.bme.aut.mobsoft.mobsoftlab.utils.GsonHelper;
import okhttp3.Headers;
import okhttp3.Request;
import okhttp3.Response;

import static hu.bme.aut.mobsoft.mobsoftlab.mock.interceptors.MockHelper.makeResponse;

public class TodoMock {
	public static Response process(Request request) {
		Uri uri = Uri.parse(request.url().toString());

		String responseString;
		int responseCode;
		Headers headers = request.headers();


		if (uri.getPath().equals(NetworkConfig.ENDPOINT_PREFIX + "todo/favourite") && request.method().equals("POST")) {
			responseString = "";
			responseCode = 200;

		/**
		 * Simple Get Example
		 */
			/*
		}else if (uri.getPath().equals(NetworkConfig.ENDPOINT_PREFIX + "Todos") && request.method().equals("Get")) {
			MemoryRepository memoryRepository = new MemoryRepository();
			memoryRepository.open(null);
			responseString = GsonHelper.getGson().toJson(memoryRepository.getFavourites());
			responseCode = 200;*/
		} else if (uri.getPath().equals(NetworkConfig.ENDPOINT_PREFIX + "login") && request.method().equals("POST")) {
			responseString="";
			responseCode = 200;
		} else if (uri.getPath().equals(NetworkConfig.ENDPOINT_PREFIX + "categories") && request.method().equals("GET")) {
			MemoryRepository memoryRepository = new MemoryRepository();
			memoryRepository.open(null);
			responseString = GsonHelper.getGson().toJson(memoryRepository.getCategories());
			responseCode = 200;
		} else if (uri.getPath().startsWith(NetworkConfig.ENDPOINT_PREFIX + "event") && request.method().equals("GET")) {
			MemoryRepository memoryRepository = new MemoryRepository();
			memoryRepository.open(null);
			if (uri.getQueryParameter("categoryId") != null) {
				String categoryId = uri.getQueryParameter("categoryId");
				responseString = GsonHelper.getGson().toJson(memoryRepository.getEventsByCategoryId(Long.parseLong(categoryId)));
			} else if (uri.getQueryParameter("eventId") != null){
				String eventId = uri.getQueryParameter("eventId");
				responseString = GsonHelper.getGson().toJson(memoryRepository.getEventById(Long.parseLong(eventId)));
			}
			else {
				responseString = "";
			}

			responseCode = 200;
		}else if (uri.getPath().startsWith(NetworkConfig.ENDPOINT_PREFIX + "attending") && request.method().equals("POST")) {
			MemoryRepository memoryRepository = new MemoryRepository();
			memoryRepository.open(null);
			String eventId = uri.getQueryParameter("eventId");
			String attending = uri.getQueryParameter("attending");
			responseString = GsonHelper.getGson().toJson(memoryRepository.setAttending(Long.parseLong(eventId), Boolean.parseBoolean(attending)));
			responseCode = 200;
		} else{
			responseString = "ERROR";
			responseCode = 503;
		}

		return makeResponse(request, headers, responseCode, responseString);
	}
}
