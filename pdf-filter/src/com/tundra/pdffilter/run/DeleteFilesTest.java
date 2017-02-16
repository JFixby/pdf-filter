
package com.tundra.pdffilter.run;

import java.io.IOException;

import com.jfixby.scarabei.api.desktop.ScarabeiDesktop;
import com.jfixby.scarabei.api.file.File;
import com.jfixby.scarabei.api.file.LocalFileSystem;
import com.jfixby.scarabei.api.log.L;
import com.jfixby.scarabei.api.sys.Sys;

public class DeleteFilesTest {

	public static void main (final String[] args) throws IOException {
		ScarabeiDesktop.deploy();

		final File deleteFolder = LocalFileSystem.ApplicationHome().child("example-folder");
		deleteFolder.makeFolder();

		final File x = makeFolder(deleteFolder, "x");
		makeFolder(deleteFolder, "y");
		makeFolder(deleteFolder, "z");

		makeFolder(x, "x");
		makeFolder(x, "y");
		makeFolder(x, "z");

		makeFile(deleteFolder, "1.txt");
		makeFile(deleteFolder, "2.txt");
		makeFile(deleteFolder, "3.txt");

		makeFile(x, "1.txt");
		makeFile(x, "2.txt");
		makeFile(x, "3.txt");

		clearFolder(deleteFolder);

	}

	private static void clearFolder (final File folder) throws IOException {
		L.d("clear", folder);
		folder.clearFolder();
	}

	private static File makeFile (final File parent, final String name) throws IOException {
		final File file = parent.child(name);
		L.d("create file", file);
		file.writeString("" + Sys.SystemTime().currentTimeMillis());
		return file;
	}

	private static File makeFolder (final File parent, final String name) throws IOException {
		final File subfolder = parent.child(name);
		L.d("create folder", subfolder);
		subfolder.makeFolder();
		return subfolder;
	}

}
