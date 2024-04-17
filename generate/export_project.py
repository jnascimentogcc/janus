import shutil

from helper.read_config import get_janus_config


def gen_export_project():
    config = get_janus_config()
    archived = shutil.make_archive(f"../export/{config['appId']}", "zip", "../output")
    print(archived)
