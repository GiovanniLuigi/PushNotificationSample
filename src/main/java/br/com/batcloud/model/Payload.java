package br.com.batcloud.model;

import java.util.Arrays;

import com.relayrides.pushy.apns.util.ApnsPayloadBuilder;

public class Payload {
	private String alertBody = null;
    private String localizedAlertKey = null;
    private String[] localizedAlertArguments = null;
    private String alertTitle = null;
    private String localizedAlertTitleKey = null;
    private String[] localizedAlertTitleArguments = null;
    private String alertSubtitle = null;
    private String localizedAlertSubtitleKey = null;
    private String[] localizedAlertSubtitleArguments = null;
    private String launchImageFileName = null;
    private boolean showActionButton = true;
    private String actionButtonLabel = null;
    private String localizedActionButtonKey = null;
    private Integer badgeNumber = null;
    private String soundFileName = null;
    private String categoryName = null;
    private boolean contentAvailable = false;
    private boolean mutableContent = false;
    private String threadId = null;
    private String[] urlArguments = null;
	public String getAlertBody() {
		return alertBody;
	}
	public void setAlertBody(String alertBody) {
		this.alertBody = alertBody;
	}
	public String getLocalizedAlertKey() {
		return localizedAlertKey;
	}
	public void setLocalizedAlertKey(String localizedAlertKey) {
		this.localizedAlertKey = localizedAlertKey;
	}
	public String[] getLocalizedAlertArguments() {
		return localizedAlertArguments;
	}
	public void setLocalizedAlertArguments(String[] localizedAlertArguments) {
		this.localizedAlertArguments = localizedAlertArguments;
	}
	public String getAlertTitle() {
		return alertTitle;
	}
	public void setAlertTitle(String alertTitle) {
		this.alertTitle = alertTitle;
	}
	public String getLocalizedAlertTitleKey() {
		return localizedAlertTitleKey;
	}
	public void setLocalizedAlertTitleKey(String localizedAlertTitleKey) {
		this.localizedAlertTitleKey = localizedAlertTitleKey;
	}
	public String[] getLocalizedAlertTitleArguments() {
		return localizedAlertTitleArguments;
	}
	public void setLocalizedAlertTitleArguments(String[] localizedAlertTitleArguments) {
		this.localizedAlertTitleArguments = localizedAlertTitleArguments;
	}
	public String getAlertSubtitle() {
		return alertSubtitle;
	}
	public void setAlertSubtitle(String alertSubtitle) {
		this.alertSubtitle = alertSubtitle;
	}
	public String getLocalizedAlertSubtitleKey() {
		return localizedAlertSubtitleKey;
	}
	public void setLocalizedAlertSubtitleKey(String localizedAlertSubtitleKey) {
		this.localizedAlertSubtitleKey = localizedAlertSubtitleKey;
	}
	public String[] getLocalizedAlertSubtitleArguments() {
		return localizedAlertSubtitleArguments;
	}
	public void setLocalizedAlertSubtitleArguments(String[] localizedAlertSubtitleArguments) {
		this.localizedAlertSubtitleArguments = localizedAlertSubtitleArguments;
	}
	public String getLaunchImageFileName() {
		return launchImageFileName;
	}
	public void setLaunchImageFileName(String launchImageFileName) {
		this.launchImageFileName = launchImageFileName;
	}
	public boolean isShowActionButton() {
		return showActionButton;
	}
	public void setShowActionButton(boolean showActionButton) {
		this.showActionButton = showActionButton;
	}
	public String getActionButtonLabel() {
		return actionButtonLabel;
	}
	public void setActionButtonLabel(String actionButtonLabel) {
		this.actionButtonLabel = actionButtonLabel;
	}
	public String getLocalizedActionButtonKey() {
		return localizedActionButtonKey;
	}
	public void setLocalizedActionButtonKey(String localizedActionButtonKey) {
		this.localizedActionButtonKey = localizedActionButtonKey;
	}
	public Integer getBadgeNumber() {
		return badgeNumber;
	}
	public void setBadgeNumber(Integer badgeNumber) {
		this.badgeNumber = badgeNumber;
	}
	public String getSoundFileName() {
		return soundFileName;
	}
	public void setSoundFileName(String soundFileName) {
		this.soundFileName = soundFileName;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public boolean isContentAvailable() {
		return contentAvailable;
	}
	public void setContentAvailable(boolean contentAvailable) {
		this.contentAvailable = contentAvailable;
	}
	public boolean isMutableContent() {
		return mutableContent;
	}
	public void setMutableContent(boolean mutableContent) {
		this.mutableContent = mutableContent;
	}
	public String getThreadId() {
		return threadId;
	}
	public void setThreadId(String threadId) {
		this.threadId = threadId;
	}
	public String[] getUrlArguments() {
		return urlArguments;
	}
	public void setUrlArguments(String[] urlArguments) {
		this.urlArguments = urlArguments;
	}
	@Override
	public String toString() {
		return "Payload [alertBody=" + alertBody + ", localizedAlertKey=" + localizedAlertKey
				+ ", localizedAlertArguments=" + Arrays.toString(localizedAlertArguments) + ", alertTitle=" + alertTitle
				+ ", localizedAlertTitleKey=" + localizedAlertTitleKey + ", localizedAlertTitleArguments="
				+ Arrays.toString(localizedAlertTitleArguments) + ", alertSubtitle=" + alertSubtitle
				+ ", localizedAlertSubtitleKey=" + localizedAlertSubtitleKey + ", localizedAlertSubtitleArguments="
				+ Arrays.toString(localizedAlertSubtitleArguments) + ", launchImageFileName=" + launchImageFileName
				+ ", showActionButton=" + showActionButton + ", actionButtonLabel=" + actionButtonLabel
				+ ", localizedActionButtonKey=" + localizedActionButtonKey + ", badgeNumber=" + badgeNumber
				+ ", soundFileName=" + soundFileName + ", categoryName=" + categoryName + ", contentAvailable="
				+ contentAvailable + ", mutableContent=" + mutableContent + ", threadId=" + threadId + ", urlArguments="
				+ Arrays.toString(urlArguments) + "]";
	}
    
    public String payload() {
	    final ApnsPayloadBuilder builder = new ApnsPayloadBuilder();
	    builder.setAlertBody(this.alertBody);
	    return builder.buildWithDefaultMaximumLength();
    }
    
}
