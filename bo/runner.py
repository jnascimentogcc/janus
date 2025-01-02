import json

from db import get_tables, get_simple_columns, get_many_to_one, get_one_to_many


def get_type(type):
    match type.upper():
        case "VARCHAR":
            return "String"
        case "CHAR":
            return "String"
        case "INT":
            return "Integer"
        case "DOUBLE":
            return "Double"
        case "DECIMAL":
            return "Double"
        case _:
            return "Object"


def get_ops():
    return [
        {
            "verb": "GET",
            "type": "SIMPLE"
        },
        {
            "verb": "GET",
            "type": "ALL",
            "orderBy": "name"
        },
        {
            "verb": "POST",
            "type": ""
        },
        {
            "verb": "PUT",
            "type": ""
        },
        {
            "verb": "DELETE",
            "type": ""
        }
    ]


arr_crud = []
arr_table = get_tables()
for table_name in arr_table:
    arr_simple_column = get_simple_columns(table_name)
    arr_many_to_one = get_many_to_one(table_name)
    arr_one_to_many = get_one_to_many(table_name)
    columns = []
    for column in arr_simple_column:
        columns.append({
            "name": column[0],
            "type": get_type(column[1]),
            "size": 0 if column[2] is None else column[2],
            "nullable": column[3].upper() == "YES",
            "unique": column[4].upper() == "UNI"
        })
    one_to_many = []
    for referenced in arr_one_to_many:
        one_to_many.append({
            "referencedTable": referenced[1]})
    many_to_one = []
    for referenced in arr_many_to_one:
        many_to_one.append({
            "referencedTable": referenced[1]
        })
    arr_crud.append({
        "table": table_name,
        "columns": columns,
        "oneToMany": one_to_many,
        "manyToOne": many_to_one,
        "ops": get_ops()
    })

buzz_process = [{
    "name": "Supply",
    "packageName": "supply",
    "cruds": arr_crud
}]

janus_conf = {
    "appName": "AutoLoan - Car Loan",
    "appId": "AutoLoan",
    "rootPackage": "com.autoloan",
    "databaseUrl": "jdbc:mysql://localhost:3306/autoloan?useSSL=false&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&allowPublicKeyRetrieval=true",
    "databaseUser": "autoloan",
    "databasePassword": "autoloan",
    "databaseSchema": "autoloan",
    "serverPort": "5001",
    "buzzDomain": buzz_process
}

with open("janus-config.json", "w") as outfile:
    json.dump(janus_conf, outfile)
