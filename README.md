# Sistema de Gestão de Clínica

Este é um projeto em Java desenvolvido para gerenciar as operações básicas de uma clínica. O sistema utiliza uma
estrutura de dados baseada em **Árvore Binária de Busca (BST)** para armazenar e organizar os registros.

## Funcionalidades

O sistema permite o gerenciamento (CRUD e listagem) de:

- **Pacientes**: Cadastro com CPF, nome, idade e convênio.
- **Profissionais**: Cadastro de médicos e outros profissionais com matrícula e formação.
- **Procedimentos**: Serviços individuais oferecidos pela clínica (ex: Consultas, Raio-X).
- **Serviços**: Registros de atendimentos realizados, vinculando paciente, profissional e procedimentos.

## Pré-requisitos

Para executar este projeto, você precisará de:

- **Java JDK 15 ou superior** (devido ao uso de *Text Blocks*).
- **Make** (ferramenta de automação de compilação).

## Como Rodar o Projeto

O projeto utiliza um `Makefile` para facilitar a compilação e execução. Abra o terminal na pasta raiz do projeto (
`sistemaClinica/`) e utilize os comandos abaixo:

### Compilar e Rodar

Para compilar o código e iniciar a aplicação imediatamente:

```bash
make ru