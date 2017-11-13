package com.example.trevi.habits.Data;

import android.provider.BaseColumns;

/**
 * API Contract for the Habit app.
 */
public final class HabitContract {

    private HabitContract() {
    }

    public static final class HabitEntry implements BaseColumns {

        public final static String TABLE_NAME = "habits";

        public final static String _ID = BaseColumns._ID;

        public final static String COLUMN_HABIT_NAME = "name";

        public final static String COLUMN_HABIT_PRIORITY = "priority";

        public final static String COLUMN_HABIT_FREQUENCY = "frequency";


        /**
         * Possible values for the frequency.
         */
        public static final int FREQUENCY_DAILY = 0;
        public static final int FREQUENCY_EVERY_OTHER = 1;
        public static final int FREQUENCY_WEEKLY = 2;
    }

}


