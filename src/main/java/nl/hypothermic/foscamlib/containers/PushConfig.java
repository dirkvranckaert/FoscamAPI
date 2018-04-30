package nl.hypothermic.foscamlib.containers;

/******************************\
 * > PushConfig.java        < *
 * FoscamAPI by hypothermic	  *
 * www.github.com/hypothermic *
\******************************/

public class PushConfig {
	
	/** Is push enabled (0-1) */
	public final String isEnabled;
	/** Current push server */
	public final PushServer server;
	/** Status message from cloud server <br><b>NOTE: </b> Call testPushServer() to find this */
	public String statusMsg;
	
	public PushConfig(final String isEnabled, final PushServer server) {
		this.isEnabled = isEnabled;
		this.server = server;
	}
	
	public PushConfig(final String isEnabled, final PushServer server, final String statusMsg) {
		this.isEnabled = isEnabled;
		this.server = server;
		this.statusMsg = statusMsg;
	}
	
	/**
	 * PushServer enum
	 */
	public static enum PushServer {
		
		// Why is there only one PushServer lol? Hello Foscam?
		BAIDU(1);
		
		private final int value;
		
		private PushServer(final int value) {
			this.value = value;
		}
		
		/**
		 * Returns int value of PushServer instance
		 * @return int value of PushServer instance
		 */
		public int getValue() {
			return this.value;
		}
		
		public static PushServer fromInt(int value) {
		      for (PushServer l : PushServer.values()) {
		          if (l.value == value) return l;
		      }
		      throw new IllegalArgumentException("Not found.");
		}
		
		public static PushServer match(String value) {
			if (value.contains("1")) return BAIDU;
			return null;
		}
	}
}
