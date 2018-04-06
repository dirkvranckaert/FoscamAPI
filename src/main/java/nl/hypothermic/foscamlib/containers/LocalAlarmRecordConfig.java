package nl.hypothermic.foscamlib.containers;

public class LocalAlarmRecordConfig {
	
	/** Is local alarm-record enabled (0-1) */
	public final String isEnabled;
	/** Record duration in seconds */
	public final String recordSecs;
	
	public LocalAlarmRecordConfig(final String isEnabled, final String recordSecs) {
		this.isEnabled = isEnabled;
		this.recordSecs = recordSecs;
	}
}
