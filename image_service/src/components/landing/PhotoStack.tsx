"use client";

import { useEffect, useState } from "react";
import { motion, AnimatePresence } from "framer-motion";
import Image from "next/image";

const images = [
  "/images/demo1.png",
  "/images/demo2.png",
  "/images/demo3.png",
];

export default function PhotoStack() {
    const [currentIndex, setCurrentIndex] = useState(0);

    useEffect(() => {
        const timer = setInterval(() => {
            setCurrentIndex((prev) => (prev + 1) % images.length);
        }, 3000);
        return () => clearInterval(timer);
    }, []);

    // Active image
    const activeImage = images[currentIndex];
    // Next image (underneath)
    const nextImage = images[(currentIndex + 1) % images.length];
    // Next next (bottom)
    const nextNextImage = images[(currentIndex + 2) % images.length];

    return (
        <div className="relative w-72 h-96 mx-auto isolate">
            {/* Bottom Card */}
            <motion.div
                key={nextNextImage + "bottom"}
                className="absolute inset-0 bg-white p-2 rounded-2xl shadow-2xl border dark:bg-zinc-900 dark:border-zinc-800"
                initial={false}
                animate={{ scale: 0.9, y: 30, rotate: -4, zIndex: 0 }}
            >
                <div className="relative w-full h-full rounded-xl overflow-hidden bg-gray-100 dark:bg-zinc-800">
                    <Image src={nextNextImage} alt="stack-3" fill className="object-cover" />
                </div>
            </motion.div>

            {/* Middle Card */}
            <motion.div
                key={nextImage + "middle"}
                className="absolute inset-0 bg-white p-2 rounded-2xl shadow-2xl border dark:bg-zinc-900 dark:border-zinc-800"
                initial={false}
                animate={{ scale: 0.95, y: 15, rotate: 2, zIndex: 1 }}
            >
                <div className="relative w-full h-full rounded-xl overflow-hidden bg-gray-100 dark:bg-zinc-800">
                    <Image src={nextImage} alt="stack-2" fill className="object-cover" />
                </div>
            </motion.div>

            {/* Top Card (Active) */}
            <AnimatePresence mode="popLayout">
                <motion.div
                    key={activeImage + "top"}
                    className="absolute inset-0 bg-white p-2 rounded-2xl shadow-2xl border dark:bg-zinc-900 dark:border-zinc-800 cursor-pointer"
                    initial={{ opacity: 0, scale: 0.95, y: 15 }} // Started from middle position
                    animate={{ opacity: 1, scale: 1, y: 0, rotate: 0, zIndex: 2 }}
                    exit={{ 
                        x: 200, 
                        opacity: 0, 
                        rotate: 15, 
                        transition: { duration: 0.4, ease: "easeIn" } 
                    }}
                    transition={{ duration: 0.4 }}
                    // Allow manual cycle on click
                    onClick={() => setCurrentIndex((prev) => (prev + 1) % images.length)}
                    whileHover={{ scale: 1.02 }}
                >
                    <div className="relative w-full h-full rounded-xl overflow-hidden bg-gray-100 dark:bg-zinc-800">
                       <Image 
                           src={activeImage} 
                           alt="stack-active" 
                           fill 
                           className="object-cover"
                           priority
                       />
                       <div className="absolute inset-0 bg-gradient-to-t from-black/50 to-transparent opacity-0 hover:opacity-100 transition-opacity duration-300 flex items-end p-4">
                            <p className="text-white font-medium">Nexus Gallery</p>
                       </div>
                    </div>
                </motion.div>
            </AnimatePresence>
        </div>
    );
}
