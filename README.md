# 💡 Projeto: Integração com Spring AI - Transcrição de Áudio
Este repositório contém uma aplicação completa (backend + frontend) desenvolvida como parte do meu aprendizado com a biblioteca Spring AI, com foco em integração com a OpenAi para realizar a Transcrição de um arquivo de áudio para texto. A aplicação permite:

# ⚙️ Tecnologias Utilizadas
### Backend:
  - Java 21
  - Spring Web – Exposição de endpoints REST
  - Spring AI – Integração com modelos da OpenAI (ChatGPT, geração de imagens, etc.)

### Frontend:
  - React

> O frontend foi desenvolvido para fins de integração com o backend, sem foco aprofundado em estilização ou arquitetura de UI/UX. O principal objetivo deste projeto está no aprendizado e prática com *Spring AI*. 

# 📚 Base de Aprendizado
Todo o código foi desenvolvido com base no curso:

📘 ([Spring AI, Java, Spring Boot + ChatGPT + Ollama + Gemini](https://www.udemy.com/course/spring-ai-java-spring-boot-open-ai-chatgpt-ollama-deepseek-gemini-grok/learn/lecture/49086321#overview))

🎓 Oferecido pela escola Erudio na plataforma Udemy.

# 🚀 Objetivo
Este projeto serviu como uma experiência prática para explorar o uso de IA generativa no ecossistema Java com Spring Boot, aplicando conceitos modernos e ferramentas atuais de inteligência artificial no desenvolvimento de APIs.

# ☝  Para você
Caso deseje utilizar a aplicação, será necessário criar uma API-KEY([Como Criar API KEY](https://hub.asimov.academy/tutorial/como-gerar-uma-api-key-na-openai/#:~:text=Crie%20uma%20Nova%20API%20Key&text=Clique%20no%20bot%C3%A3o%20%E2%80%9CCreate%20new,em%20%E2%80%9CCreate%20secret%20key%E2%80%9D)) no site da OpenAi e adicionar na linha 6 do [aplication.yml](https://github.com/BrunoKayser/SpringAi-OpenAi/blob/main/api/spring-ai-erudio/src/main/resources/application.yml)) no backend 
No entanto não é um serviço gratuíto, a OpenAi cobra valores para utilização de suas APIS, recomendo entender como funcionam as cobranças para text, imagens, entre outros ([Tabela de preços OPENAI](https://openai.com/api/pricing/)).
