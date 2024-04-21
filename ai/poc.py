from openai import OpenAI

client = OpenAI(
    organization="org-Q1HVeMNdryVyQSQTSGpIRZac",
    api_key="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"
)

file_prompt = open('../ai/files.prompt', 'r')
files = file_prompt.readlines()
prompts = []
for x in files:
    file_content = open(x.replace("\n", ""), 'r')
    prompts.append({
        "role": "user",
        "content": file_content.read()
    })
prompts.append({
    "role": "user",
    "content": "Generate a Java method beteween bracktes in the servicesupply class to calculate the total of a specific order from the order entity by adding the price multiplied by the quantity and applying the discount percentage to all items in the order in the order item entity"
})

response = client.chat.completions.create(
    model="gpt-3.5-turbo",
    messages=prompts
)
print(response.choices[0].message.content)
"""
response = client.chat.completions.create(
  model="gpt-3.5-turbo",
  messages=[
    {"role": "user", "content": "Generate a Java method to be added in SupplyController.java that call the service method that calculate the total of the order"},
  ]
)

f_controller = open("../output/src/main/java/com/autoloan/supply/controller/SupplyController.java", "r")

response = client.chat.completions.create(
  model="gpt-3.5-turbo",
  messages=[
    {"role": "user", "content": f_order_entity.read()},

print(response.choices[0].message.content)
"""
# {"role": "user", "content": ""},
# {"role": "user", "content": f_.read()},
