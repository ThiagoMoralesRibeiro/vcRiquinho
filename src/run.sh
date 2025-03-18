#!/bin/bash
echo "Compilando o projeto..."
javac -d out -sourcepath . view/App.java

if [ $? -eq 0 ]; then
    echo "Execução do projeto..."
    java -cp out view.App
else
    echo "Erro na compilação!"
fi

