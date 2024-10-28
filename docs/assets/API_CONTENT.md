
# Documentación de la API

## Descripción
Esta API recibe información de satélites, incluyendo el nombre, la distancia, y un mensaje fragmentado. Basado en la información, la API calcula o determina la información solicitada (por ejemplo, la posición de un objeto o el mensaje completo).

---

## Ejemplo de Solicitud

### Endpoint
- **URL**: `.../topsecret/
- **Método**: `POST`
- **Encabezados**:
  - `Content-Type: application/json`

### Cuerpo (Payload)
El cuerpo de la solicitud debe incluir un arreglo de satélites, cada uno con su nombre, distancia y un mensaje en formato de arreglo de strings. Los elementos vacíos del mensaje representan palabras faltantes o fragmentos omitidos.

```json
{
  "satelites": [
    {
      "name": "Kenobi",
      "distancia": 100,
      "message": ["este", "", "", "mensaje", ""]
    },
    {
      "name": "skywalker",
      "distancia": 115.5,
      "message": ["", "es", "", "", "secreto"]
    },
    {
      "name": "sato",
      "distancia": 142.7,
      "message": ["este", "", "un", "", ""]
    }
  ]
}
```

---

## Respuesta esperada

```json
{
  "status": "success",
  "data": {
    "position": {
      "x": -100.5,
      "y": 75.4
    },
    "message": "este es un mensaje secreto"
  }
}
```

