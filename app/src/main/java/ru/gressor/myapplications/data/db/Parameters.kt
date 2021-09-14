package ru.gressor.myapplications.data.db

const val DB_FILE_NAME = "apps-database"

const val DB_TABLE_NAME_APPS = "apps"

const val DB_TABLE_APPS_COLUMN_ID = "id"
const val DB_TABLE_APPS_COLUMN_PACKAGE = "package"
const val DB_TABLE_APPS_COLUMN_NAME = "name"
const val DB_TABLE_APPS_COLUMN_TAGS = "tags"
const val DB_TABLE_APPS_COLUMN_INSTALLED = "installed"

const val DATABASE_CREATE_TABLE_APPS =
    """CREATE TABLE IF NOT EXISTS $DB_TABLE_NAME_APPS (
        | $DB_TABLE_APPS_COLUMN_ID INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
        | $DB_TABLE_APPS_COLUMN_PACKAGE TEXT NOT NULL,
        | $DB_TABLE_APPS_COLUMN_NAME TEXT NOT NULL,
        | $DB_TABLE_APPS_COLUMN_TAGS TEXT NOT NULL,
        | $DB_TABLE_APPS_COLUMN_INSTALLED INTEGER NOT NULL
        );"""

const val DB_DROP_TABLE_APPS = "DROP TABLE IF EXISTS $DB_TABLE_NAME_APPS;"