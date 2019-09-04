//
//  RevenueMonster.swift
//  RevenueMonster
//
//  Created by Jun Kai Gan on 23/07/2019.
//  Copyright © 2019 Facebook. All rights reserved.
//

import Foundation

@objc(RevenueMonster)
class RevenueMonster: NSObject {
    
    @objc(addEvent:location:date:)
    func addEvent(name: String, location: String, date: NSNumber) -> Void {
        // Date is ready to use!
    }
    
    @objc
    func constantsToExport() -> [AnyHashable : Any]! {
        return ["initialCount": 0]
    }
}
