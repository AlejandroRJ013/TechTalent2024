use ejercicio03;

db.createCollection('almacenes');

db.almacenes.insertMany([
    {
    "codigo": 1,
    "lugar": "Bilbao",
    "capacidad": 25,
    },
    {
    "codigo": 2,
    "lugar": "Madrid",
    "capacidad": 10,
    },
    {
    "codigo": 3,
    "lugar": "Lanzarote",
    "capacidad": 32,
    }
]);

db.createCollection('cajas');

db.cajas.insertMany([
    {
    "num_ref": 1,
    "contenido": "Pilas",
    "valor": 2.20,
    "almacen": 2,
    },
    {
    "num_ref": 3,
    "contenido": "Ropa",
    "valor": 10.50,
    "almacen": 2,
    },
    {
    "num_ref": 1,
    "contenido": "Juguetes",
    "valor": 3.75,
    "almacen": 3,
    },
    {
    "num_ref": 2,
    "contenido": "Sartenes",
    "valor": 29.99,
    "almacen": 3,
    },
    {
    "num_ref": 3,
    "contenido": "Platos",
    "valor": 12.30,
    "almacen": 1,
    },
    {
    "num_ref": 2,
    "contenido": "Trapos",
    "valor": 6.60,
    "almacen": 1,
    }
]);