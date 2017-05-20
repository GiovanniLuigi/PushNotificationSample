package br.com.batcloud.model;

import java.util.Arrays;

import com.relayrides.pushy.apns.util.ApnsPayloadBuilder;

public class Payload {
	private String alertBody = null;
    private String alertTitle = null;
    private String alertSubtitle = null;
    private String launchImageFileName = null;
    private boolean showActionButton = true;
    private String actionButtonLabel = null;
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

	public String getAlertTitle() {
		return alertTitle;
	}

	public void setAlertTitle(String alertTitle) {
		this.alertTitle = alertTitle;
	}

	public String getAlertSubtitle() {
		return alertSubtitle;
	}

	public void setAlertSubtitle(String alertSubtitle) {
		this.alertSubtitle = alertSubtitle;
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
		return "Payload [alertBody=" + alertBody + ", alertTitle=" + alertTitle + ", alertSubtitle=" + alertSubtitle
				+ ", launchImageFileName=" + launchImageFileName + ", showActionButton=" + showActionButton
				+ ", actionButtonLabel=" + actionButtonLabel + ", badgeNumber=" + badgeNumber + ", soundFileName="
				+ soundFileName + ", categoryName=" + categoryName + ", contentAvailable=" + contentAvailable
				+ ", mutableContent=" + mutableContent + ", threadId=" + threadId + ", urlArguments="
				+ Arrays.toString(urlArguments) + "]";
	}

	public String payload() {
	    final ApnsPayloadBuilder builder = new ApnsPayloadBuilder();
	    builder.setAlertBody(this.alertBody);
	    builder.setAlertSubtitle(this.alertSubtitle);
	    builder.setAlertTitle(this.alertTitle);
	    builder.setLaunchImageFileName(this.launchImageFileName);
	    builder.setActionButtonLabel(this.actionButtonLabel);
	    builder.setShowActionButton(this.showActionButton);
	    builder.setBadgeNumber(this.badgeNumber);
	    builder.setSoundFileName(this.soundFileName);
	    builder.setCategoryName(this.categoryName);
	    builder.setContentAvailable(this.contentAvailable);
	    builder.setMutableContent(this.mutableContent);
	    builder.setThreadId(this.threadId);
	    builder.setUrlArguments(this.urlArguments);
	    
	    return builder.buildWithDefaultMaximumLength();
    }
    
}
