package com.cb.constants;

import com.cb.enums.ConfigProperties;
import com.cb.utils.ReadPropertyFile;

public final class FrameworkConstants {

	private FrameworkConstants() {

	}

	private static final int EXPLICITWAIT = 20;
	private static final int IMPLICITWAIT = 20;
	private static final int PAGELOADTIME = 30;

	private static final String RESOURCEPATH = System.getProperty("user.dir") + "/src/test/resources/";
	private static final String CONFIGFILEPATH = RESOURCEPATH + "config/config.properties";
	private static final String EXTENTREPORTPATH = System.getProperty("user.dir") + "/extent-test-output/";
	private static final String EXCELFILEPATH = RESOURCEPATH + "excel/testexecutiondetails.xlsx";
	
	private static final String RUNMANAGERSHEET ="RUNMANAGER";
	private static final String DATASHEET = "DATA";

	public static String getRunmanagersheet() {
		return RUNMANAGERSHEET;
	}

	public static String getDatasheet() {
		return DATASHEET;
	}

	public static String getExcelfilepath() {
		return EXCELFILEPATH;
	}

	private static String extentFolderpath = "";

	public static String getExtentreportpath()  {
		if (extentFolderpath.isEmpty()) {
			extentFolderpath = createReport();
		}
		return extentFolderpath;

	}

	private static String createReport()  {
		if (ReadPropertyFile.get(ConfigProperties.OVERRIDEREPORTS).equalsIgnoreCase("no")) {
			return EXTENTREPORTPATH + System.currentTimeMillis() + "/index.html";
		} else {
			return EXTENTREPORTPATH + "index.html";
		}
	}

	public static int getImplicitwait() {
		return IMPLICITWAIT;
	}

	public static int getPageloadtime() {
		return PAGELOADTIME;
	}

	public static int getExplicitwait() {
		return EXPLICITWAIT;
	}

	public static String getConfigfilepath() {
		return CONFIGFILEPATH;
	}

}
