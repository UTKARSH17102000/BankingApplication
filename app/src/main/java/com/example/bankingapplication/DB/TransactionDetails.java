package com.example.bankingapplication.DB;

import android.provider.BaseColumns;

public final class TransactionDetails {
    private TransactionDetails() {}

    public static final class TransactionEntry implements BaseColumns {

        public final static String TABLE_NAME = "Transaction_table";


        public final static String _ID = BaseColumns._ID;
        public final static String COLUMN_FROM_NAME = "from_name";
        public final static String COLUMN_TO_NAME = "to_name";
        public final static String COLUMN_AMOUNT = "amount";
        public final static String COLUMN_STATUS = "status";
    }
}
