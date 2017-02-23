package com.fitbit.api.services;

import android.app.Activity;
import android.support.annotation.NonNull;

import com.fitbit.api.APIUtils;
import com.fitbit.api.MissingScopesException;
import com.fitbit.api.ResourceLoadedHandler;
import com.fitbit.api.ResourceLoader;
import com.fitbit.api.TokenExpiredException;
import com.fitbit.api.models.CaloriesContainer;
import com.fitbit.authentication.AuthenticationManager;
import com.fitbit.authentication.Scope;

/**
 * Created by bsilva on 2/23/17.
 */

public class CaloriesService {

    private final static String CALORIES_URL = "https://api.fitbit.com/1/user/-/activities/calories/date/2016-05-18/1d/15min.json";
    private static final ResourceLoader<CaloriesContainer> USER_CALORIES_LOADER = new ResourceLoader<>(CALORIES_URL, CaloriesContainer.class);

    public static void getUserCaloriesToday(Activity activityContext, @NonNull final ResourceLoadedHandler<CaloriesContainer> handler) throws MissingScopesException, TokenExpiredException {
        APIUtils.validateToken(activityContext, AuthenticationManager.getCurrentAccessToken(), Scope.activity);
        USER_CALORIES_LOADER.loadResource(activityContext, handler);
    }
}
