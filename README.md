# Barbershop SaaS - Full Enterprise

## Overview
Sistema SaaS completo para gestão de barbearias com arquitetura pronta para produção.

## Features
- Autenticação JWT completa
- Multi-tenant por tenant_id
- CRUD: clientes, barbeiros, serviços e agendamentos
- Controle de planos SaaS
- Validação de conflitos de agenda

## Stack
Backend: Spring Boot
Frontend: Next.js
Banco: PostgreSQL
Infra: Docker

## Run
1. docker-compose up --build
2. acessar localhost:3000

## SaaS
- Básico: 1 barbeiro
- Pro: 5 barbeiros
- Premium: ilimitado

## Modules
- auth
- tenant
- customer
- barber
- service
- appointment

## Future
- integração WhatsApp
- pagamentos
- dashboard BI
