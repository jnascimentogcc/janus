from openai import OpenAI

client = OpenAI(
  organization="org-Q1HVeMNdryVyQSQTSGpIRZac",
  api_key="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"
)

f_order_entity = open("../output/src/main/java/com/autoloan/supply/model/OrderEntity.java")
f_item_order_entity = open("../output/src/main/java/com/autoloan/supply/model/ItemOrderEntity.java")
f_tax_entity = open("../output/src/main/java/com/autoloan/supply/model/TaxEntity.java")
f_order_repository = open("../output/src/main/java/com/autoloan/supply/model/OrderRepository.java")
f_item_order_repository = open("../output/src/main/java/com/autoloan/supply/model/ItemOrderRepository.java")
f_tax_repository = open("../output/src/main/java/com/autoloan/supply/model/TaxRepository.java")
f_order_dto = open("../output/src/main/java/com/autoloan/supply/dto/OrderDTO.java")
f_item_order_dto = open("../output/src/main/java/com/autoloan/supply/dto/ItemOrderDTO.java")
f_tax_dto = open("../output/src/main/java/com/autoloan/supply/dto/TaxDTO.java")
f_service = open("../output/src/main/java/com/autoloan/supply/service/SupplyService.java", "r")
f_controller = open("../output/src/main/java/com/autoloan/supply/controller/SupplyController.java", "r")

response = client.chat.completions.create(
  model="gpt-3.5-turbo",
  messages=[
    {"role": "user", "content": f_order_entity.read()},
    {"role": "user", "content": f_item_order_entity.read()},
    {"role": "user", "content": f_tax_entity.read()},
    {"role": "user", "content": f_order_repository.read()},
    {"role": "user", "content": f_item_order_repository.read()},
    {"role": "user", "content": f_tax_repository.read()},
    {"role": "user", "content": f_order_dto.read()},
    {"role": "user", "content": f_item_order_dto.read()},
    {"role": "user", "content": f_tax_dto.read()},
    {"role": "user", "content": f_service.read()},
    {"role": "user", "content": f_controller.read()},
    {"role": "user", "content": "Generate a Java method to be added in SupplyService.java that calculate the total of the order"},
    {"role": "user",
     "content": "Generate a Java method to be added in SupplyController.java that call the service method that calculate the total of the order"},
    {"role": "user",
     "content": "Generate a Java method to be added in SupplyService.java that calculate the VAT of the order"},
    {"role": "user",
     "content": "Generate a Java method to be added in SupplyController.java that call the service method that calculate the VAT of the order"},

    {"role": "user",
     "content": "Generate a Java method to be added in SupplyService.java that calculate the total + VAT of the order"},
    {"role": "user",
     "content": "Generate a Java method to be added in SupplyController.java that call the service method that calculate the total + VAT of the order"},
  ]
)
print(response.choices[0].message.content)
"""
response = client.chat.completions.create(
  model="gpt-3.5-turbo",
  messages=[
    {"role": "user", "content": "Generate a Java method to be added in SupplyController.java that call the service method that calculate the total of the order"},
  ]
)
print(response.choices[0].message.content)
"""
# {"role": "user", "content": ""},
# {"role": "user", "content": f_.read()},
