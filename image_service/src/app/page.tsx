import PhotoStackV2 from "@/components/landing/PhotoStack";
import { Button } from "@/components/ui/button";
import { ArrowRight, Image as ImageIcon, Zap } from "lucide-react";

export default function Home() {
  return (
    <div className="min-h-screen bg-background flex flex-col">
      {/* Navigation / Header */}
      <header className="border-b border-border/40 bg-background/95 backdrop-blur supports-[backdrop-filter]:bg-background/60">
        <div className="container flex h-14 max-w-screen-2xl items-center justify-between px-4">
          <div className="flex items-center gap-2 font-bold text-xl tracking-tight">
            <div className="bg-primary text-primary-foreground p-1 rounded-lg">
                <ImageIcon size={20} />
            </div>
            <span>Nexus Image</span>
          </div>
          <nav className="flex items-center gap-4 text-sm font-medium text-muted-foreground">
            <a href="#" className="hover:text-foreground transition-colors">Documentation</a>
            <a href="#" className="hover:text-foreground transition-colors">API</a>
            <Button variant="ghost" size="sm">Sign In</Button>
          </nav>
        </div>
      </header>

      <main className="flex-1 flex flex-col relative overflow-hidden">
        {/* Background Elements */}
        <div className="absolute inset-0 -z-10 h-full w-full bg-background bg-[linear-gradient(to_right,#8080800a_1px,transparent_1px),linear-gradient(to_bottom,#8080800a_1px,transparent_1px)] bg-[size:14px_24px]"></div>
        <div className="absolute left-0 right-0 top-0 -z-10 m-auto h-[310px] w-[310px] rounded-full bg-primary/20 opacity-20 blur-[100px]"></div>

        <section className="container px-4 py-24 md:py-32 flex flex-col md:flex-row items-center gap-12 md:gap-24 max-w-screen-xl mx-auto">
          {/* Left Content */}
          <div className="flex-1 space-y-8 text-center md:text-left">
            <div className="space-y-4">
              <h1 className="text-4xl md:text-6xl font-extrabold tracking-tighter text-foreground">
                The <span className="text-primary bg-clip-text text-transparent bg-gradient-to-r from-primary to-purple-600">Central Nervous System</span> for Your Digital Visuals.
              </h1>
              <p className="text-lg md:text-xl text-muted-foreground max-w-[600px] mx-auto md:mx-0 leading-relaxed">
                Experience high-performance image processing, real-time optimization, and seamless delivery. 
                Built for the Nexus Ecosystem using the power of Next.js and Spring Boot.
              </p>
            </div>
            
            <div className="flex flex-col sm:flex-row items-center justify-center md:justify-start gap-4">
              <Button size="lg" className="w-full sm:w-auto gap-2 group">
                Get Started 
                <ArrowRight size={16} className="group-hover:translate-x-1 transition-transform" />
              </Button>
              <Button size="lg" variant="outline" className="w-full sm:w-auto gap-2">
                <Zap size={16} className="text-yellow-500" />
                View Performance
              </Button>
            </div>

            <div className="pt-8 flex items-center justify-center md:justify-start gap-8 text-sm text-muted-foreground">
              <div className="flex items-center gap-2">
                <span className="w-2 h-2 rounded-full bg-green-500 animate-pulse"></span>
                <span>Systems Operational</span>
              </div>
              <div>
                Processing <span className="font-bold text-foreground">1M+</span> images/day
              </div>
            </div>
          </div>

          {/* Right Content - Animation */}
          <div className="flex-1 flex justify-center md:justify-end relative">
             <div className="relative">
                <div className="absolute -inset-4 bg-gradient-to-r from-primary/30 to-purple-600/30 rounded-full blur-3xl opacity-30 animate-pulse"></div>
                <PhotoStackV2 />
             </div>
          </div>
        </section>
      </main>

       {/* Footer */}
       <footer className="border-t border-border/40 py-6 md:py-0">
        <div className="container flex flex-col items-center justify-between gap-4 md:h-16 md:flex-row px-4">
          <p className="text-sm text-muted-foreground">
            © 2026 Nexus Ecosystem. Engineered with passion.
          </p>
        </div>
      </footer>
    </div>
  );
}
