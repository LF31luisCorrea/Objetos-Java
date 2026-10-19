DROP TABLE IF EXISTS Orçamentos;
DROP TABLE IF EXISTS Objetivos;
DROP TABLE IF EXISTS MetasSolo;
DROP TABLE IF EXISTS MetasOrquestra;
DROP TABLE IF EXISTS Metas;
DROP TABLE IF EXISTS Estudos;
DROP TABLE IF EXISTS Alunos;

 CREATE TABLE Alunos (
    Nome VARCHAR(255) PRIMARY KEY,
    Cpf VARCHAR(255) NOT NULL,
    Instrumento INTEGER NOT NULL,
    Telefone VARCHAR(255) NOT NULL,
    Endereço VARCHAR(255) NOT NULL
 );

 CREATE TABLE Estudos (
    Nome VARCHAR(255) PRIMARY KEY,
    Autor VARCHAR(255) NOT NULL,
    Dificuldade INTEGER NOT NULL,
    Tipo_lição INTEGER NOT NULL,
    Duração INTEGER NOT NULL,
    Quantidade_aulas INTEGER NOT NULL
 );

 CREATE TABLE Metas(
      Sequencial INT NOT NULL AUTO_INCREMENT PRIMARY KEY, 
      Nome VARCHAR(255) NOT NULL,
      Dia_aula INT NOT NULL,
      Aula_especial BIT(1) NOT NULL	
);

 CREATE TABLE Objetivos(
      Sequencial INT NOT NULL AUTO_INCREMENT PRIMARY KEY, 
      MetaId INT NOT NULL,
      EstudoId VARCHAR(255) NOT NULL,
      FOREIGN KEY (MetaId) REFERENCES Metas(Sequencial), 
      FOREIGN KEY (EstudoId) REFERENCES Estudos(Nome)	
);

CREATE TABLE MetasSolo(
   Tipo_aprendizado INT NOT NULL,
   Tempo INT NOT NULL,
   MetaId INT NOT NULL,
   FOREIGN KEY (MetaId) REFERENCES Metas(Sequencial));
 

CREATE TABLE MetasOrquestra (
   Tipo_orquestra INT NOT NULL,
   Nível INT NOT NULL,
   MetaId INT NOT NULL,
   FOREIGN KEY (MetaId) REFERENCES Metas(Sequencial));

CREATE TABLE Orçamentos (
   Sequencial INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
   AlunoId VARCHAR(50) NOT NULL,
   MetaId INT NOT NULL,
   Valor_aula FLOAT NOT NULL,
   Pagamento INT NOT NULL,
   Promoção BIT(1) NOT NULL,	
   FOREIGN KEY (AlunoId) REFERENCES Alunos(Nome),
   FOREIGN KEY (MetaId) REFERENCES Metas(Sequencial));
