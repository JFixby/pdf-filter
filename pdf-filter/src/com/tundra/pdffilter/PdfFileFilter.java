
package com.tundra.pdffilter;

import java.io.IOException;

import com.jfixby.scarabei.api.file.File;
import com.jfixby.scarabei.api.file.FileFilter;

public class PdfFileFilter implements FileFilter {

	@Override
	public boolean fits (final File element) {
		try {
// L.d("element", element);
			final String ext = element.getExtension();
			return "pdf".equals(ext);
		} catch (final IOException e) {
			e.printStackTrace();
		}

		return false;
	}

}
