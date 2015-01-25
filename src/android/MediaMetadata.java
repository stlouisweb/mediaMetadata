package com.stlouisweb.mediametadata;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONObject;
import org.json.JSONArray;
import org.json.JSONException;

import android.media.MediaMetadataRetriever;

public class MediaMeta extends CordovaPlugin {
    public static final String GET_MEDIA_METADATA = "getMediaMetadata";
    	public static String ALBUM;
    	public static String ARTIST;
    	public static String TRACKNUMBER;
    	public static String TITLE;



   @Override
       public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
           try {
               if (GET_MEDIA_METADATA.equals(action)) {
                       JSONObject arg_object = args.getJSONobject(0);
                       JSONObject trackinfo = new JSONObject();
                       Intent calIntent = new Intent(Intent.GET_METADATA)
                       .setType("vnd.android.cursor.item/event")
                       .putExtra("fullpath", arg_object.getString("fullpath"));
                    MediaMetadataRetriever meta = new MediaMetadataRetriever();
                       meta.setDataSource(fullpath);

                   ALBUM = meta.extractMetadata(MediaMetadataRetriever.METADATA_KEY_ALBUM);
                   ARTIST = meta.extractMetadata(MediaMetadataRetriever.METADATA_KEY_ARTIST);
                   TRACKNUMBER = meta.extractMetadata(MediaMetadataRetriever.METADATA_KEY_CD_TRACK_NUMBER);
                   TITLE = meta.extractMetadata(MediaMetadataRetriever.METADATA_KEY_TITLE);

                    trackinfo.put("album", ALBUM);
                    trackinfo.put("artist", ARTIST);
                    trackinfo.put("trackNumber", TRACKNUMBER);
                    trackinfo.put("title", TITLE);
                   this.cordova.getActivity().startActivity(calIntent);
                   callbackContext.success(trackinfo);
                   return true;
               }
               callbackContext.error("Invalid action");
               return false;
           } catch(Exception e) {
               System.err.println("Exception: " + e.getMessage());
               callbackContext.error(e.getMessage());
               return false;
           }
       }
   }