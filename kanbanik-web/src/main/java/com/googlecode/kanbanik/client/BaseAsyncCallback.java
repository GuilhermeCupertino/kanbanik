package com.googlecode.kanbanik.client;


import com.google.gwt.user.client.rpc.AsyncCallback;
import com.googlecode.kanbanik.client.components.ErrorDialog;
import com.googlecode.kanbanik.client.security.CurrentUser;
import com.googlecode.kanbanik.dto.shell.FailableResult;
import com.googlecode.kanbanik.shared.UserNotLoggedInException;

public class BaseAsyncCallback<T> implements AsyncCallback<T> {

	public void onFailure(Throwable caught) {
		KanbanikProgressBar.hide();
		
		if (caught instanceof UserNotLoggedInException) {
			// just log him out - he lost the session
			new ErrorDialog("You are no longer logged in").show();
			CurrentUser.getInstance().logoutFrontend();
		} else {
			new ErrorDialog(caught).show();
		}
	}
	
	public void onSuccess(T result) {
		KanbanikProgressBar.hide();
		
		if (result instanceof FailableResult<?>) {
			FailableResult<?> failableResult = (FailableResult<?>) result;
			if (!failableResult.isSucceeded()) {
				handleFaildResult(failableResult);
			} else {
				beforeSuccess(result);
				success(result);
			}
		} else {
			beforeSuccess(result);
			success(result);
		}
		
	}

	@SuppressWarnings("unchecked")
	protected void handleFaildResult(FailableResult<?> failableResult) {
		new ErrorDialog(failableResult.getMessage()).center();
		failure((T) failableResult);
	}

	/**
	 * This method is not meant to be owerridden in client code
	 */
	void beforeSuccess(T result) {
		
	}
	
	public void success(T result) {
	}
	
	public void failure(T result) {
	}
}