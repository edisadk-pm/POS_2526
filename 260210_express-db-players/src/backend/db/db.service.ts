import mongoose from "mongoose";
import {PlayerDB} from "../models/db.models";

const DB_URL:string = process.env.DB_URL || "mongodb://localhost:27017/Player";
import mockplayers from "../mockdata/mockdaten.json";

export async function connectDB() {
    try{
        await mongoose.connect(DB_URL);
        console.log("MongoDB connected");
    }catch (err){
        console.error("MongoDB connection error: ", err);
    }
}

export const initDB = async () => {
    try{
        await PlayerDB.deleteMany({});
        const result = await PlayerDB.insertMany(mockplayers);
        console.log("MongoDB Data Inserted: length: " + result.length);
    }
        catch (err){
        console.error("DB initialization error: ", err);
    }
}