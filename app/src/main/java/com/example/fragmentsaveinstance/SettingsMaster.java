package com.example.fragmentsaveinstance;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Класс, который ведет чтение и запись в {@link android.content.SharedPreferences}
 */
public class SettingsMaster
{
    private static final String FILE_SETTINGS = "preference";
    private static final String DATA_FROM_SECOND_FRAGMENT = "data_from_second_fragment";

    private static SharedPreferences getPreference(final Context context)
    {
        return context.getSharedPreferences(FILE_SETTINGS, 0);
    }

    private static SharedPreferences.Editor getEditor(final Context context)
    {
        return getPreference(context).edit();
    }


    public static void setDataFromSecondFragment(final Context context, final String s)
    {
        getEditor(context).putString(DATA_FROM_SECOND_FRAGMENT, s).apply();
    }

    public static String getDataFromSecondFragment(final Context context)
    {
        return getPreference(context).getString(DATA_FROM_SECOND_FRAGMENT, "");
    }

}
