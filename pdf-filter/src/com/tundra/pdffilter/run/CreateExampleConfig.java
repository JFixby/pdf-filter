
package com.tundra.pdffilter.run;

import java.io.IOException;

import com.jfixby.scarabei.api.desktop.ScarabeiDesktop;
import com.jfixby.scarabei.api.file.File;
import com.jfixby.scarabei.api.file.LocalFileSystem;
import com.jfixby.scarabei.api.json.Json;
import com.jfixby.scarabei.api.json.JsonString;
import com.jfixby.scarabei.api.log.L;
import com.jfixby.scarabei.gson.GoogleGson;
import com.tundra.pdffilter.PdfFilterConfig;

public class CreateExampleConfig {

	public static void main (final String[] args) throws IOException {

		ScarabeiDesktop.deploy();
		Json.installComponent(new GoogleGson());

		final PdfFilterConfig config = new PdfFilterConfig();
		config.target_folder_path = "D:\\";

		final File configFile = LocalFileSystem.ApplicationHome().child("config")
			.child(PdfFilterConfig.PDF_FILTER_CONFIG_FILE_NAME);

		final JsonString serializedString = Json.serializeToString(config);

		L.d("serializedString:");
		L.d();
		L.d(serializedString);
		L.d();
		L.d("writing file", configFile);
		configFile.writeString(serializedString.toString());

	}

}
