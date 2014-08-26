package com.paitoanderson.stepcounter.data;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Paito Anderson on 2014-04-26.
 */
public class Preferences {

    // Identify Shared Preference Store
    public final static String PREFS_NAME = "stepcounter_prefs";

    // How many steps have I walked?
    public static int getStepCount(Context context) {
        SharedPreferences prefs = context.getSharedPreferences(PREFS_NAME, 0);
        return (prefs.getInt("stepCount", 0) - prefs.getInt("stepCountSubtract", 0));
    }

    // Set how many steps I have walked.
    public static void setStepCount(Context context, Integer steps) {
        SharedPreferences prefs = context.getSharedPreferences(PREFS_NAME, 0);
        SharedPreferences.Editor prefsEditor = prefs.edit();
        prefsEditor.putInt("stepCount", steps);
        prefsEditor.apply();
    }

    // Set Subtract Step Count (Reset)
    public static void resetStepCount(Context context) {
        SharedPreferences prefs = context.getSharedPreferences(PREFS_NAME, 0);
        SharedPreferences.Editor prefsEditor = prefs.edit();
        prefsEditor.putInt("stepCountSubtract", prefs.getInt("stepCount", 0));
        prefsEditor.apply();
    }

    // Reset the Subtract Step Count (On Boot)
    public static void clearStepCount(Context context) {
        SharedPreferences prefs = context.getSharedPreferences(PREFS_NAME, 0);
        SharedPreferences.Editor prefsEditor = prefs.edit();
        prefsEditor.putInt("stepCountSubtract", 0);
        prefsEditor.putInt("stepCount", 0);
        prefsEditor.apply();
    }

    // When was the last FitBit Sync
    public static long getFitbitSyncDate(Context context)
    {
        SharedPreferences prefs = context.getSharedPreferences(PREFS_NAME, 0);
        return prefs.getLong("fitbitSyncDate", 0);
    }

    // Set last FitBit Sync Date
    public static void setFitbitSyncDate(Context context, Long timestamp) {
        SharedPreferences prefs = context.getSharedPreferences(PREFS_NAME, 0);
        SharedPreferences.Editor prefsEditor = prefs.edit();
        prefsEditor.putLong("fitbitSyncDate", timestamp);
        prefsEditor.apply();
    }
}