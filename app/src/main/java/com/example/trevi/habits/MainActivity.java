package com.example.trevi.habits;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.trevi.habits.Data.HabitContract;
import com.example.trevi.habits.Data.HabitDbHelper;

public class MainActivity extends AppCompatActivity {

    private HabitDbHelper mDbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDbHelper = new HabitDbHelper(this);
        WriteDb();
        Cursor cursor = ReadDb();

        try {
            int nameColumnIndex = cursor.getColumnIndex(HabitContract.HabitEntry.COLUMN_HABIT_NAME);
            int priorityColumnIndex = cursor.getColumnIndex(HabitContract.HabitEntry.COLUMN_HABIT_PRIORITY);
            int frequencyColumnIndex = cursor.getColumnIndex(HabitContract.HabitEntry.COLUMN_HABIT_FREQUENCY);
            while (cursor.moveToNext()) {
                String currentName = cursor.getString(nameColumnIndex);
                String currentPriority = cursor.getString(priorityColumnIndex);
                int currentFrequency = cursor.getInt(frequencyColumnIndex);
                Log.d("HABITINFO", "Name: " + currentName);
                Log.d("HABITINFO", "Priority: " + currentPriority);
                Log.d("HABITINFO", "Frequency: " + currentFrequency);
            }
        } finally {
            cursor.close();
        }

    }

    private Cursor ReadDb() {
        SQLiteDatabase db = mDbHelper.getReadableDatabase();

        String[] projection = {
                HabitContract.HabitEntry._ID,
                HabitContract.HabitEntry.COLUMN_HABIT_NAME,
                HabitContract.HabitEntry.COLUMN_HABIT_PRIORITY,
                HabitContract.HabitEntry.COLUMN_HABIT_FREQUENCY};

        Cursor cursor = db.query(
                HabitContract.HabitEntry.TABLE_NAME,   // The table to query
                projection,            // The columns to return
                null,           // The columns for the WHERE clause
                null,       // The values for the WHERE clause
                null,           // Don't group the rows
                null,            // Don't filter by row groups
                null);          // The sort order

        return cursor;
    }

    private void WriteDb() {

    }
}
