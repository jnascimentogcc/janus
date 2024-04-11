import shutil

from helper.read_config import get_janus_config

config = get_janus_config()
archived = shutil.make_archive(f"../export/{config['appId']}", "zip", "../output")
print(archived)
