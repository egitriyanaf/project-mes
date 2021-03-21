package com.agit.util;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author erwin
 */
public class CsvExport {
	List<String> columns = new ArrayList<String>();
	String separator = "~";
	String workDir = "";
	Writer writer;
	File file;
	DateFormat format = new SimpleDateFormat("yyyyddmmhhMMss");
	
    /**
     *
     * @return
     */
    public String getSeparator() {
		return separator;
	}

    /**
     *
     * @param separator
     */
    public void setSeparator(String separator) {
		this.separator = separator;
	}

	static final String CRLF = System.getProperty("line.separator");

    /**
     *
     * @return
     */
    public String getWorkDir() {
		return workDir;
	}

    /**
     *
     * @param workDir
     */
    public void setWorkDir(String workDir) {
		this.workDir = workDir;
	}
	
    /**
     *
     * @param title
     * @throws IOException
     */
    public void addTitle(String title) throws IOException{
		 
		
		this.writer.write(title);
		 
	}

    /**
     *
     * @param footer
     * @throws IOException
     */
    public void addFooter(String footer) throws IOException{
	 
	
	this.writer.write(footer);
	 
}

    /**
     *
     * @param col
     * @throws IOException
     */
    public void addColumn(String col) throws IOException{
		this.columns.add(col);
		
		this.writer.write(col);
		this.writer.write(this.separator);
	}
	
    /**
     *
     * @throws IOException
     */
    public void enter() throws IOException{
		this.writer.write(CRLF);
	}
	
    /**
     *
     * @param row
     * @throws IOException
     */
    public void addRow(List<String> row) throws IOException{		
		for (String s : row) {
			if (s == null) s = ""; 
			this.writer.write(s);
			this.writer.write(this.separator);
			
		}
		this.writer.write(CRLF);
	}
	
    /**
     *
     * @return
     * @throws IOException
     */
    public Reader getReader() throws IOException{		
		return new BufferedReader(new FileReader(this.file));
	}
	
    /**
     *
     * @throws IOException
     */
    public void flush() throws IOException{
		this.writer.flush();
		this.writer.close();
	}
	
    /**
     *
     * @throws IOException
     */
    public void init() throws IOException {

		File out = createFile(getWorkDir());
		this.file = out;
		BufferedWriter writer = new BufferedWriter(new FileWriter(this.file));
		
		this.writer = writer;
	}
	
	private File createFile(String rootDir){
		String fname = String.format("csv_export_%s.csv", this.format.format(new Date()));
		File file = new File(workDir+fname);
		return file;
	}
	
    /**
     *
     */
    public void cleanup(){
		this.file.delete();
	}

}
