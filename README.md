## Gerenciador de gastos  
- Java  
- Python  
- Docker  
- Kafka  
- MySql  
- Clean Architerure  
- Microserviços  
  
## Projeto  
Gerenciado salva no Mysql uma despesa e chama o microserviço geradorCSV  
O geradorcsv recebe o conteudo via kafka e gera um relatorio.csv  
Quando o usuario desejar analisar o relatorio basta iniciar o serviço analizador  

### Docker  

#### rede  
docker network create rede-despesas

#### Criar imagem
 docker image build -t gerenciador-despesa .
 docker image build -t analizador .  
 docker image build -t gerador-csv .

#### Executar docker-compose
docker-compose up  
  
#### Criar topicos no kafka  
kafka-topics --list --bootstrap-server localhost:9092  
kafka-topics --create --bootstrap-server localhost:9092 --replication-factor 1 --partitions 3 --topic CALCULAR_DESPESA

## Arquitetura Limpa  
  
### Entidade  
Classes referentes as regras de negocio da aplicação (Lembrar que nao é com relação ao banco de dados...)  
  
### Casos de uso  
Orientam o fluxo de dados apartir da entidade e para entidade  

### Adaptadores de interface  
Faz a conversao de dados da melhor maneira para uso das entidades e dos agentes externos  
  
### Frameworks e Drivers  
Frameworks e DB que podem facilmente ser substituidos

### Minha versão  
  
app   
&emsp;&emsp;&emsp;|-> adapter   
&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;|-> gateway (Vai fazer acesso externos como repository e kafka)  
&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;|-> rest (Quem recebe a entrada de dados via rest)  
&emsp;&emsp;&emsp;|-> core   
&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;|-> domain (Mantem a entidade)  
&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;|-> usecase (Mantem o usecase e as ports de entrada e saida)  
&emsp;&emsp;&emsp;|-> dataprovider (Mantem tudo que for relacionado a acesso aos DB)  