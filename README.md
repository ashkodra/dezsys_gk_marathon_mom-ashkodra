# GK771 Middleware Engineering "Marathon - REST"


## Voraussetzungen
- Java (am besten Version 17) 
-  Gradle (am besten 7.5.1) <br>
-  Java Programmierkenntnisse <br> 
-  Verwendung von Gradle und Git <br>
-  Grundlagen Dezentrale Systeme <br>
-  Grundlagen XML<br>
-  Grundlagen JSON & REST<br>

## Installieren und ausführen

Übung zu Middleware Engineering "Marathon - MoM" (MICT)
Übung zu Middleware Engineering "Marathon - MoM" (MICT)
Start von ActiveMQ: 
![image](https://github.com/ashkodra/Mom/assets/94531999/db9cc2af-201d-4700-b5b4-ed3f1ddc5e0c)
1 Nachrichtenschlange pro Timingstation
JSON und XML-Struktur erweitern
Control Station --> MongoDB
 ![image](https://github.com/ashkodra/Mom/assets/94531999/e78d4ea9-e281-43e3-98d7-c6ab8fd10423)
Jetzt sollte unter http://localhost:8161/admin/ activemq laufen. 
![image](https://github.com/ashkodra/Mom/assets/94531999/441042ce-436a-4401-9630-87a6848f1348)
![image](https://github.com/ashkodra/Mom/assets/94531999/64fc2b29-5b31-4098-8e4c-f74a5c53418a)

1.4.1 marathon_demo1
Demo 1 beinhaltet eine Implementierung, die alle Einzelschritte zur Implementierung von Java und JMS beinhaltet und uebersichtlich darstellt. Die JMS Teile Sender und Empfaenger werden einzeln aufgerufen.
•	Starten des Empfaengers MOMReceiver
gradle clean bootRun -Pargs=receiver
•	Starten des Sender MOMSender
gradle clean bootRun -Pargs=sender
![image](https://github.com/ashkodra/Mom/assets/94531999/8cc47dd9-266d-455f-88a5-6525576bf82d)
![image](https://github.com/ashkodra/Mom/assets/94531999/87ac7c2f-84cf-494b-b9f6-61a7269b28dd)

## Sender-Projekt:
Diese MarathonApplication-Klasse ermöglicht es dem Benutzer, wiederholt Timingstation-IDs einzugeben, die entsprechenden Timingstation-Daten abzurufen und sie an eine MOM zu senden. Die Schleife wird so lange wiederholt, bis der Benutzer "no" eingibt, um das Programm zu beenden.
![image](https://github.com/ashkodra/Mom/assets/94531999/ba06e4a5-254b-4b38-bab7-be73ca040e51)

 
SpringApplication.run(MarathonApplication.class, args);
Diese Methode startet die Ausführung einer Spring Boot-Anwendung.
TimingstationService service = new TimingstationService();
Erstellung einer Instanz der Klasse TimingstationService.
MOMSender sender = new MOMSender(data):
Eine Instanz der Klasse "MOMSender" wird erstellt und mit den Timingstation-Daten "data" initialisiert.
In dieser main-Methode der MarathonApplication-Klasse findet die gesamte Interaktion mit dem Benutzer statt.


Hier werden Daten der Klasse TimingstationData übergeben und an den Receiver geschickt.
 ![image](https://github.com/ashkodra/Mom/assets/94531999/0e4814fa-7390-411b-9e71-2063ee843718)

In diesem Konstruktor wird die Verbindung mit ActiveMQ hergestellt. Zudem wird auch eine Session erstellt, eine Connection aufgebaut, ein Topic festgelegt und ein Zielort festgelegt, wo die Daten gesendet werden.
 ![image](https://github.com/ashkodra/Mom/assets/94531999/429213e1-34de-4af9-b6d8-4a1d9ea4ba42)

Mit „producer.send(message);“ werden die Daten der TimingstationData an den Zielort geschickt.
Dann wird mit connection.stop, die Verbindung abgebrochen.

## Receiver-Projekt:
 ![image](https://github.com/ashkodra/Mom/assets/94531999/5eba4925-e836-426f-9510-c84b53718663)
Gleich wie bei MOM-Server: Verbindung wird hergestellt.
 ![image](https://github.com/ashkodra/Mom/assets/94531999/ca98636b-f4e3-480c-880d-770f16d3e215)

Hier werden die Übergebenen Messages empfangen und in einem String umgewandelt. Zudem kommen noch eine Bestätigung und ein Verbindungsabbruch.
 ![image](https://github.com/ashkodra/Mom/assets/94531999/da4e2e24-97cd-4a56-925b-139ff80ce0fa)
Mit dieser Methode empfängt man die Timingstationdaten.
 ![image](https://github.com/ashkodra/Mom/assets/94531999/92a5f989-3d64-4f56-90b2-3be4fb09569f)
![image](https://github.com/ashkodra/Mom/assets/94531999/a3cedf63-32b2-43c0-8108-fc3da0d6b086)

 
So sieht die Interaktion mit dem Benutzer aus:
Beim Receiver mit: gradle clean bootRun -Pargs=receiver
![image](https://github.com/ashkodra/Mom/assets/94531999/42d77f00-a291-4a37-86e6-c72807bdc0fb)
![image](https://github.com/ashkodra/Mom/assets/94531999/66da5b1b-7755-408d-8643-b3108e06906d)
![image](https://github.com/ashkodra/Mom/assets/94531999/67233313-ef0a-4cb4-a76e-cb28e07b74af)
![image](https://github.com/ashkodra/Mom/assets/94531999/290badf7-d33b-4baf-a42a-84ec41fca3e6)

 
Hier die JSON-Ausgabe:
 ![image](https://github.com/ashkodra/Mom/assets/94531999/6d3b96b7-c013-41d1-a256-387060693647)

Hier die XML-Ausgabe:
 ![image](https://github.com/ashkodra/Mom/assets/94531999/f390df47-60fb-4b07-aabc-f3ad798d4953)
![image](https://github.com/ashkodra/Mom/assets/94531999/700778f6-bc4d-48b7-817a-322274e2cf4d)

 
Hier die Topics-Ansicht(bitte nur TimingstationData beachten):
 ![image](https://github.com/ashkodra/Mom/assets/94531999/8fcdf9c3-3dab-49d6-9933-26d0c7f52da2)
 <br>
Der Grund warum 12 Messages Enqueued und Dequeued wurden ist, dass ich schon zuvor einige Tests gemacht habe.
Fragestellung für Protokoll <br>

•	Nennen Sie mindestens 4 Eigenschaften der Message Oriented Middleware? <br>

Die Kommunikation kann Minuten (nicht ms) dauern <br>

Grundidee: Nachricht werden in Warteschlange einfügen <br>

Es herrscht eine persistente (asynchrone) Kommunikation <br>

Zwischenspeicherkapazität für Nachrichten im Kommunikationsnetz <br>

•	Was versteht man unter einer transienten und synchronen Kommunikation? <br>

Synchron: Sender ist blockiert bis: Gepuffert beim empfangenden Host, an den Empfänger zugestellt wurde der Empfänger die Nachricht verarbeitet hat
Transiente Kommunikation: Nachricht wird nur so lange gespeichert solange Sender und Empfänger die Nachricht ausführen. <br>

•	Beschreiben Sie die Funktionsweise einer JMS Queue? <br>

Arbeitet nach dem Point-to-Point-Modell(jede Nachricht wird von einem Sender an einen Empfänger gesendet, der diese spezielle Nachricht empfängt und verarbeitet).  <br>

Ein Sender (oder Produzent) erstellt eine Nachricht und sendet sie an die Queue. <br>

Die Queue speichert die Nachricht in ihrer Warteschlange. <br>

Ein Empfänger (oder Konsument) meldet sich bei der Queue an, um Nachrichten abzurufen. <br>

Die Queue liefert die Nachricht an den Empfänger, der sie verarbeitet und bestätigt, dass er sie empfangen hat.
Die Nachricht wird aus der Warteschlange gelöscht <br>

•	JMS Overview - Beschreiben Sie die wichtigsten JMS Klassen und deren Zusammenhang? <br>

ConnectionFactory: kreiert Connection <br>

Connection: kreiert Session <br>

Session: kreiert MessageProducer und MessageConsumer <br>

MessageProducer: schickt zu Destination <br>

MessageConsumer: erhält von Destination <br>

•	Beschreiben Sie die Funktionsweise eines JMS Topic? <br>

Es gibt M Verleger und N Abonnenten. Dabei wird eine Nachricht an alle Abonnenten zugestellt. Jedoch gibt es keine Garantie für die Reihenfolge der Nachrichten. <br>


•	Was versteht man unter einem losen gekoppelten verteilten System? Nennen Sie ein Beispiel dazu. Warum spricht man hier von lose? <br>

In einem solchen System findet Kommunikation zwischen Komponenten statt, wobei sie nicht direkt voneinander abhängig sind. Das WWW ist ein verteiltes System, da es aus vielen verschiedenen Servern und Websites besteht, die über das Internet miteinander kommunizieren.  <br>
Man spricht von einer losen Kopplung, da das System flexibler und widerstandsfähiger gegen Änderungen ist und die Komponenten nicht alles voneinander wissen.

