# Hateoas
Exemplo de uso do (Hypermedia as the Engine of Application State) HATEOAS.

##### http://localhost:8080/order
Devolve uma lista com todos os pedidos e seus itens e respectivos links.
````
{
    "_embedded": {
        "orderResponseList": [
            {
                "orderId": 1105,
                "itemResponseList": [
                    {
                        "item": {
                            "itemId": 308,
                            "itemDesc": "Relogio",
                            "itemAmount": 1,
                            "itemPrice": 900.0
                        },
                        "_links": {
                            "Order": {
                                "href": "http://localhost:8080/order/1105"
                            },
                            "self": {
                                "href": "http://localhost:8080/order/1105/item/308"
                            }
                        }
                    },
                    {
                        "item": {
                            "itemId": 530,
                            "itemDesc": "Notebook",
                            "itemAmount": 1,
                            "itemPrice": 2900.0
                        },
                        "_links": {
                            "Order": {
                                "href": "http://localhost:8080/order/1105"
                            },
                            "self": {
                                "href": "http://localhost:8080/order/1105/item/530"
                            }
                        }
                    },
                    {
                        "item": {
                            "itemId": 330,
                            "itemDesc": "Pasta",
                            "itemAmount": 1,
                            "itemPrice": 290.0
                        },
                        "_links": {
                            "Order": {
                                "href": "http://localhost:8080/order/1105"
                            },
                            "self": {
                                "href": "http://localhost:8080/order/1105/item/330"
                            }
                        }
                    }
                ],
                "_links": {
                    "Order List": {
                        "href": "http://localhost:8080/order"
                    },
                    "self": {
                        "href": "http://localhost:8080/order/1105"
                    }
                }
            },
            {
                "orderId": 1005,
                "itemResponseList": [
                    {
                        "item": {
                            "itemId": 418,
                            "itemDesc": "Celular",
                            "itemAmount": 1,
                            "itemPrice": 900.0
                        },
                        "_links": {
                            "Order": {
                                "href": "http://localhost:8080/order/1005"
                            },
                            "self": {
                                "href": "http://localhost:8080/order/1005/item/418"
                            }
                        }
                    },
                    {
                        "item": {
                            "itemId": 660,
                            "itemDesc": "Televisor",
                            "itemAmount": 1,
                            "itemPrice": 2900.0
                        },
                        "_links": {
                            "Order": {
                                "href": "http://localhost:8080/order/1005"
                            },
                            "self": {
                                "href": "http://localhost:8080/order/1005/item/660"
                            }
                        }
                    },
                    {
                        "item": {
                            "itemId": 130,
                            "itemDesc": "Relogio",
                            "itemAmount": 1,
                            "itemPrice": 290.0
                        },
                        "_links": {
                            "Order": {
                                "href": "http://localhost:8080/order/1005"
                            },
                            "self": {
                                "href": "http://localhost:8080/order/1005/item/130"
                            }
                        }
                    }
                ],
                "_links": {
                    "Order List": {
                        "href": "http://localhost:8080/order"
                    },
                    "self": {
                        "href": "http://localhost:8080/order/1005"
                    }
                }
            }
        ]
    }
}
````
