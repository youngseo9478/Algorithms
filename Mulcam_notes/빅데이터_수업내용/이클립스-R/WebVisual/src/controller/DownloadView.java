package controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.util.FileCopyUtils;
import org.springframework.web.servlet.view.AbstractView;

public class DownloadView extends AbstractView {
	public static final String RESULT_DIR = "C://Users/student/workspace/rClient/";

	private String file;

	public DownloadView(String file) {
		this.file = file;
	}

	@Override
	protected void renderMergedOutputModel(Map<String, Object> arg0, HttpServletRequest arg1, HttpServletResponse resp)
			throws Exception {
		File file = new File(RESULT_DIR+File.separator+this.file);
		resp.setContentType("application/download; utf-8");
		resp.setContentLength((int)file.length());
		resp.setHeader("Content-Disposition",
				"attachment; filename=\""
				+ this.file + "\";");
		resp.setHeader("Content-Transfer-Encoding", "binary");
		OutputStream out = resp.getOutputStream();
		FileInputStream fis = new FileInputStream(file);
		FileCopyUtils.copy(fis, out);
		out.flush();
	}

}
