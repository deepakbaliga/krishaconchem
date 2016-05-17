package com.deepakbaliga.krishnaconchem.retrofit;

import retrofit2.Response;

/**
 * Created by baliga on 04/05/16.
 */
    public interface APIResponseCallback {

        public void onSuccess(Response response );
        public void onFailure(String error);
    }


