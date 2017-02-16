
package com.tundra.pdffilter.run;

import java.io.IOException;

import com.jfixby.scarabei.adopted.gdx.json.GoogleGson;
import com.jfixby.scarabei.api.desktop.ScarabeiDesktop;
import com.jfixby.scarabei.api.file.File;
import com.jfixby.scarabei.api.file.FileFilter;
import com.jfixby.scarabei.api.file.FilesList;
import com.jfixby.scarabei.api.file.LocalFileSystem;
import com.jfixby.scarabei.api.json.Json;
import com.jfixby.scarabei.api.log.L;
import com.tundra.pdffilter.PdfFileFilter;
import com.tundra.pdffilter.PdfFilterConfig;

public class FilterFiles {

	public static void main (final String[] args) throws IOException {
		ScarabeiDesktop.deploy();
		Json.installComponent(new GoogleGson());

		final File configFile = LocalFileSystem.ApplicationHome().child("config")
			.child(PdfFilterConfig.PDF_FILTER_CONFIG_FILE_NAME);

		final String stringData = configFile.readToString();

		final PdfFilterConfig config = Json.deserializeFromString(PdfFilterConfig.class, stringData);

		final File targetFolder = LocalFileSystem.newFile(config.target_folder_path);

		L.d("scanning", targetFolder);

		final FileFilter pdfFileFilter = new PdfFileFilter();
		final FilesList pdfFiles = targetFolder.listAllChildren(pdfFileFilter);

		pdfFiles.print("pdfFiles");

	}

}
