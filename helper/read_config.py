import json


def get_janus_config():
    file_config = open("../config/janus-config.json")
    data = json.load(file_config)
    file_config.close()
    return data
