-- Insert Categorias
INSERT INTO categoria (nome) VALUES ('Bebidas');
INSERT INTO categoria (nome) VALUES ('Pratos Principais');
INSERT INTO categoria (nome) VALUES ('Sobremesas');
INSERT INTO categoria (nome) VALUES ('Aperitivos');
INSERT INTO categoria (nome) VALUES ('Saladas');

-- Insert Mesas (numero é auto-gerado)
INSERT INTO mesa (disponivel) VALUES (true);
INSERT INTO mesa (disponivel) VALUES (true);
INSERT INTO mesa (disponivel) VALUES (false);
INSERT INTO mesa (disponivel) VALUES (true);
INSERT INTO mesa (disponivel) VALUES (true);

-- Insert Garcons
INSERT INTO garcom (nome) VALUES ('João Silva');
INSERT INTO garcom (nome) VALUES ('Maria Santos');
INSERT INTO garcom (nome) VALUES ('Pedro Oliveira');

-- Insert Clientes
INSERT INTO cliente (nome, data_nascimento, hora_chegada, hora_saida) 
VALUES ('Ana Costa', '1990-05-15', '2024-01-15 12:00:00', '2024-01-15 14:30:00');

INSERT INTO cliente (nome, data_nascimento, hora_chegada, hora_saida) 
VALUES ('Carlos Mendes', '1985-12-04', '2024-01-15 13:00:00', '2024-01-15 15:00:00');

INSERT INTO cliente (nome, data_nascimento, hora_chegada, hora_saida)
VALUES ('Beatriz Lima', '1992-12-04', '2024-01-15 18:00:00', NULL);

INSERT INTO cliente (nome, data_nascimento, hora_chegada, hora_saida)
VALUES ('Roberto Alves', '1988-12-10', '2024-01-15 19:00:00', NULL);

INSERT INTO cliente (nome, data_nascimento, hora_chegada, hora_saida)
VALUES ('Fernanda Souza', '1994-12-10', '2024-01-04 20:00:00', NULL);

-- Insert Itens do Cardapio
INSERT INTO item_cardapio (ingredientes, preco, disponivel_na_cozinha, categoria_id) 
VALUES ('Cachaça, açúcar, limão, gelo', 5.50, true, 1);

INSERT INTO item_cardapio (ingredientes, preco, disponivel_na_cozinha, categoria_id) 
VALUES ('Refrigerante gelado', 8.00, true, 1);

INSERT INTO item_cardapio (ingredientes, preco, disponivel_na_cozinha, categoria_id) 
VALUES ('Carne bovina, batata frita, salada', 35.90, true, 2);

INSERT INTO item_cardapio (ingredientes, preco, disponivel_na_cozinha, categoria_id) 
VALUES ('Frango grelhado, arroz, feijão', 28.50, true, 2);

INSERT INTO item_cardapio (ingredientes, preco, disponivel_na_cozinha, categoria_id) 
VALUES ('Peixe grelhado, legumes', 42.00, true, 2);

INSERT INTO item_cardapio (ingredientes, preco, disponivel_na_cozinha, categoria_id) 
VALUES ('Pudim de leite condensado', 12.00, true, 3);

INSERT INTO item_cardapio (ingredientes, preco, disponivel_na_cozinha, categoria_id) 
VALUES ('Brigadeiro, beijinho', 15.00, true, 3);

INSERT INTO item_cardapio (ingredientes, preco, disponivel_na_cozinha, categoria_id) 
VALUES ('Batata frita, molho especial', 18.00, true, 4);

INSERT INTO item_cardapio (ingredientes, preco, disponivel_na_cozinha, categoria_id) 
VALUES ('Alface, tomate, cebola, azeite', 16.50, true, 5);

-- Insert Contas
INSERT INTO conta (nome) VALUES ('Conta Mesa 1');
INSERT INTO conta (nome) VALUES ('Conta Mesa 2');
INSERT INTO conta (nome) VALUES ('Conta Mesa 3');
INSERT INTO conta (nome) VALUES ('Conta Mesa 4');
INSERT INTO conta (nome) VALUES ('Conta Mesa 5');
INSERT INTO conta (nome) VALUES ('Conta Mesa 6');

-- Insert Pedidos
INSERT INTO pedido (cliente_id, data_pedido, hora_entrega, conta_id, mesa_numero) 
VALUES (1, '2024-01-15 12:15:00', '2024-01-15 12:45:00', 1, 1);

INSERT INTO pedido (cliente_id, data_pedido, hora_entrega, conta_id, mesa_numero) 
VALUES (2, '2024-01-15 13:10:00', '2024-01-15 13:40:00', 2, 2);

INSERT INTO pedido (cliente_id, data_pedido, hora_entrega, conta_id, mesa_numero) 
VALUES (3, '2024-01-15 18:15:00', NULL, 3, 3);

INSERT INTO pedido (cliente_id, data_pedido, hora_entrega, conta_id, mesa_numero) 
VALUES (4, '2024-01-15 19:20:00', NULL, 4, 4);

INSERT INTO pedido (cliente_id, data_pedido, hora_entrega, conta_id, mesa_numero) 
VALUES (5, '2024-01-15 20:00:00', '2024-01-15 20:35:00', 5, 5);

INSERT INTO pedido (cliente_id, data_pedido, hora_entrega, conta_id, mesa_numero) 
VALUES (1, '2024-01-15 14:00:00', '2024-01-15 14:25:00', 6, 1);

-- Insert ItemPedido
INSERT INTO item_pedido (item_cardapio_id, quantidade, pedido_id) VALUES (1, 2, 1);
INSERT INTO item_pedido (item_cardapio_id, quantidade, pedido_id) VALUES (3, 1, 1);
INSERT INTO item_pedido (item_cardapio_id, quantidade, pedido_id) VALUES (6, 1, 1);

INSERT INTO item_pedido (item_cardapio_id, quantidade, pedido_id) VALUES (2, 1, 2);
INSERT INTO item_pedido (item_cardapio_id, quantidade, pedido_id) VALUES (4, 2, 2);

INSERT INTO item_pedido (item_cardapio_id, quantidade, pedido_id) VALUES (5, 1, 3);
INSERT INTO item_pedido (item_cardapio_id, quantidade, pedido_id) VALUES (1, 2, 3);

INSERT INTO item_pedido (item_cardapio_id, quantidade, pedido_id) VALUES (3, 1, 4);
INSERT INTO item_pedido (item_cardapio_id, quantidade, pedido_id) VALUES (8, 1, 4);

INSERT INTO item_pedido (item_cardapio_id, quantidade, pedido_id) VALUES (2, 2, 5);
INSERT INTO item_pedido (item_cardapio_id, quantidade, pedido_id) VALUES (7, 1, 5);

INSERT INTO item_pedido (item_cardapio_id, quantidade, pedido_id) VALUES (1, 3, 6);
INSERT INTO item_pedido (item_cardapio_id, quantidade, pedido_id) VALUES (3, 1, 6);
