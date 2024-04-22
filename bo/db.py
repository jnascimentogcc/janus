import mysql.connector

config = {
  'user': 'autoloan',
  'password': 'autoloan',
  'host': '127.0.0.1',
  'database': 'autoloan',
  'raise_on_warnings': True
}


def get_tables():
    cnx = mysql.connector.connect(**config)
    if cnx and cnx.is_connected():
        with cnx.cursor() as cursor:
            cursor.execute("SELECT TABLE_NAME FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_SCHEMA = 'autoloan'")
            rows = cursor.fetchall()
            arr_table = []
            for row in rows:
                arr_table.append(row[0])
        cnx.close()
        return arr_table
    else:
        return []


def get_simple_columns(table_name):
    cnx = mysql.connector.connect(**config)
    if cnx and cnx.is_connected():
        with cnx.cursor() as cursor:
            cursor.execute(f"SELECT COLUMN_NAME, DATA_TYPE, CHARACTER_MAXIMUM_LENGTH, IS_NULLABLE, COLUMN_KEY FROM INFORMATION_SCHEMA.COLUMNS WHERE TABLE_SCHEMA = 'autoloan' AND TABLE_NAME = '{table_name}' AND COLUMN_KEY NOT IN ('PRI', 'MUL') ORDER BY ORDINAL_POSITION")
            rows = cursor.fetchall()
            arr_column = []
            for row in rows:
                arr_column.append(row)
        cnx.close()
        return arr_column
    else:
        return []


def get_many_to_one(table_name):
    cnx = mysql.connector.connect(**config)
    if cnx and cnx.is_connected():
        with cnx.cursor() as cursor:
            cursor.execute(f"SELECT TABLE_NAME, REFERENCED_TABLE_NAME FROM INFORMATION_SCHEMA.KEY_COLUMN_USAGE WHERE TABLE_SCHEMA = 'autoloan' AND TABLE_NAME = '{table_name}' AND REFERENCED_TABLE_NAME IS NOT NULL ORDER BY ORDINAL_POSITION")
            rows = cursor.fetchall()
            arr_related = []
            for row in rows:
                arr_related.append(row)
        cnx.close()
        return arr_related
    else:
        return []


def get_one_to_many(table_name):
    cnx = mysql.connector.connect(**config)
    if cnx and cnx.is_connected():
        with cnx.cursor() as cursor:
            cursor.execute(f"SELECT REFERENCED_TABLE_NAME, TABLE_NAME FROM INFORMATION_SCHEMA.KEY_COLUMN_USAGE WHERE TABLE_SCHEMA = 'autoloan' AND REFERENCED_TABLE_NAME = '{table_name}' ORDER BY ORDINAL_POSITION")
            rows = cursor.fetchall()
            arr_related = []
            for row in rows:
                arr_related.append(row)
        cnx.close()
        return arr_related
    else:
        return []
