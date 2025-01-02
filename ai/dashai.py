# Example: reuse your existing OpenAI setup
from openai import OpenAI

# Point to the local server
client = OpenAI(base_url="http://localhost:9876/v1", api_key="lm-studio")

completion = client.chat.completions.create(
  model="llama-3.2-3b-instruct",
  messages=[
    {"role": "user", "content": "Quem foi o vendedor da loja americanas que mais vendeu em dezembro de 2024?"},
  ],
  temperature=0.7,
)

print(completion.choices[0].message)
