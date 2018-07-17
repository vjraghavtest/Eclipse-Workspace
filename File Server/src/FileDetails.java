
public class FileDetails {
	private String name,checksum;
	private long filesize;

	public FileDetails(String name, String checksum,long filesize) {
		this.name = name;
		this.checksum = checksum;
		this.filesize=filesize;
	}

	public long getFilesize() {
		return filesize;
	}

	public String getName() {
		return name;
	}

	public String getChecksum() {
		return checksum;
	}
	
}
