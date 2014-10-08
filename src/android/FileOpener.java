package io.github.pwlin.cordova.plugins.fileopener2;

import java.io.IOException;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.PluginResult;
import org.json.JSONArray;
import org.json.JSONException;

import android.content.Intent;
import android.net.Uri;

import com.radaee.reader.PDFReaderAct;

public class FileOpener2 extends CordovaPlugin {

	/**
	 * Executes the request and returns a boolean.
	 * 
	 * @param action
	 *            The action to execute.
	 * @param args
	 *            JSONArry of arguments for the plugin.
	 * @param callbackContext
	 *            The callback context used when calling back into JavaScript.
	 * @return boolean.
	 */
	public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
//		  public PluginResult execute(String action, JSONArray args, CallbackContext callbackId) {
		        PluginResult.Status status = PluginResult.Status.OK;
		        String result = "";
		            if (action.equals("openFile")) {
		                try {
							openFile(args.getString(0),args.getString(1),args.getString(2),args.getString(3),args.getString(4),args.getString(5),args.getString(6),args.getString(7),args.getString(8),args.getString(9),args.getString(10),args.getString(11));
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
		            }
		            else {
		                status = PluginResult.Status.INVALID_ACTION;
		            }
					return true;
		    }
		    private void openFile(String url,String aCellId,String obj,String deviceId,String rcid ,String userId,String orgId,String sid,String logKey, String jsonCount,String fileName,String aContentId) throws IOException {
		        // Create URI
		        Uri uri = Uri.parse(url);
		        Intent intent = null;
		        intent = new Intent(this.cordova.getActivity().getApplicationContext(), PDFReaderAct.class);
		    	this.cordova.getActivity().overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
				intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); 
		    	intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		    	intent.setAction(Intent.ACTION_VIEW);
		    	intent.setData(uri);
		    	intent.putExtra("contentId", aCellId);
		    	intent.putExtra("subsectionJson",obj.toString());
		    	intent.putExtra("deviceId", deviceId);
		    	intent.putExtra("rcid",rcid);
		    	intent.putExtra("userId",userId);
		    	intent.putExtra("orgId",orgId);
		    	intent.putExtra("sid",sid);
		    	intent.putExtra("logKey", logKey);
		    	intent.putExtra("jsonCount", jsonCount);
		    	intent.putExtra("fileName", fileName);
		    	intent.putExtra("aContentId", aContentId);
//		        this.cordova.getActivity().startActivityForResult(intent,0);
		    	this.cordova.getActivity().startActivity(intent);
		    }

		}
