# Example: reuse your existing OpenAI setup
from openai import OpenAI

# Point to the local server
client = OpenAI(base_url="http://localhost:9876/v1", api_key="lm-studio")

completion = client.chat.completions.create(
  model="hermes-3-llama-3.1-8b",
  messages=[
    {"role": "system", "content": "O vendedor Jorge Nascimento vendeu 10000 itens em dezembro de 2024 na loja dashai de Viseu."},
    {"role": "system", "content": "O vendedor Caio Nascimento vendeu 9000 itens em dezembro de 2024 na loja dashai de Viseu."},
    {"role": "system", "content": "A vendedora Caroline Gomes vendeu 8000 itens em dezembro de 2024 na loja dashai de Viseu."},
    {"role": "system", "content": "A vendedora Caroline Gomes vendeu 6000 itens em novembro de 2024 na loja dashai de Viseu."},
    {"role": "system", "content": "A vendedora Eliane Brito vendeu 9500 itens em dezembro de 2024 na loja dashai de Viseu."},
    {"role": "system", "content": "O vendedor Vinicius Silva vendeu 11000 itens em dezembro de 2024 na loja dashai de Almada."},
    {"role": "system", "content": "A vendedora Ana Gabriela vendeu 9500 itens em dezembro de 2024 na loja dashai de Almada."},
    {"role": "system", "content": "O vendedor Felipe Mayvorm vendeu 8000 itens em novembro de 2024 na loja dashai de Viseu."},
    {"role": "system", "content": "A vendedora Dory Lee vendeu 12000 itens em novembro de 2024 na loja dashai de Viseu."},
    {"role": "user", "content": "Quem foi o vendedor da loja dashai que mais vendeu somando os meses de novembro e dezembro de 2024 ? Liste apenas o vencedor com o total de itens vendidos"},
  ],
  temperature=0.7,
)

print(completion.choices[0].message)
