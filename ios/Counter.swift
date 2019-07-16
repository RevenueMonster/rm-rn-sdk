//
//  Counter.swift
//  RevenueMonster
//
//  Created by Jun Kai Gan on 16/07/2019.
//  Copyright © 2019 Facebook. All rights reserved.
//

import Foundation

@objc(Counter)
class Counter: NSObject {
    
    @objc
    func constantsToExport() -> [AnyHashable: Any]! {
        return ["initialCount": 0]
    }
}
