package application;

public class AnnouncementTable {
		private int AnnouncementID;
		private String AnnouncementContent;
		
		
		
		
		public AnnouncementTable() {
			this.AnnouncementID=0;
		}
		public AnnouncementTable(int AnnouncementID, String AnnouncementContent) {
			this.AnnouncementID=AnnouncementID;
			this.AnnouncementContent=AnnouncementContent;
			
		}
		public int getAnnouncementID() {
			return AnnouncementID;
		}
		public void setAnnouncementID(int announcementID) {
			AnnouncementID = announcementID;
		}
		public String getAnnouncementContent() {
			return AnnouncementContent;
		}
		public void setAnnouncementContent(String announcementContent) {
			AnnouncementContent = announcementContent;
		}
		
		
		
		
}
