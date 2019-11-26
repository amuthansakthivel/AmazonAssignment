package com.amazon.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import com.amazon.constants.Constants;
import com.jayway.jsonpath.JsonPath;


public class JsonParser {
	private static File jsonFile;

	public static String getValue(String path) throws IOException   {

		jsonFile=new File(Constants.JSONPATH);
		return JsonPath.read(jsonFile,"$."+path);

	}
}
