//db.models.ts
//DB Schema (Vorlage
// für Datenstruktur) und DB Model als


import mongoose from "mongoose";

const schema = new mongoose.Schema(
    {
    id: String,
    name: String,
    }
);

export const PlayerDB = mongoose.model("Player", schema);